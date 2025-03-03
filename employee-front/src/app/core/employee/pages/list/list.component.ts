import { CurrencyPipe, DatePipe } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { NgbPaginationModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeService } from '../../services/employee.service';
import { NgbAlertModule } from '@ng-bootstrap/ng-bootstrap';
import { Alert } from '../../../../common/interfaces/alert.interface';
import { Employee } from '../../interfaces/employee.interface';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [CurrencyPipe, FormsModule, NgbAlertModule, NgbTypeaheadModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  employees!: Employee[];

  employeeId!: number;
  //Alert
  close: boolean = true; 
  alert: Alert = { type: '', message: '' };

  private employeeService = inject(EmployeeService);
  
  async ngOnInit(){
    this.fetchEmployees();
  }
  
  async search() {
    const response = await this.employeeService.getEmployee(this.employeeId)
    if (response) {
      this.employees = [response];
    }
    else{
      this.showAlert('danger', 'Employee not found');
      setInterval(() => this.closeAlert(), 3000);
    }
  }

  async searchEmpty() {
    if(this.employeeId === null){
      this.fetchEmployees();
    }
  }

  async fetchEmployees() {
    const response = await this.employeeService.getEmployees();
    this.employees = response;
  }

  closeAlert() {
    this.alert = { type: '', message: '' };
  }
  showAlert(type: string, message: string) {
    this.alert = {type, message};
  }
}
