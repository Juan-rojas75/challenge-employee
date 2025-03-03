import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { environment } from '../../../../enviroments/enviroment';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private httpClient = inject(HttpClient);

  async getEmployees() {
    return await firstValueFrom(
      this.httpClient.get<any>( environment.apiUrl + '/employees', { headers: { 'Content-Type': 'application/json' } })
    );
  }

  async getEmployee(id: number) {
    return await firstValueFrom(
      this.httpClient.get<any>( environment.apiUrl + '/employee/' + id , { headers: { 'Content-Type': 'application/json' , 'Access-Control-Allow-Origin': '*'} })
    );
  }

}
