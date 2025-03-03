import { Component } from '@angular/core';
import { NavbarComponent } from '../../common/components/navbar/navbar.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [NavbarComponent, RouterModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {

}
