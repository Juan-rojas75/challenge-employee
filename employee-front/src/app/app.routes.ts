import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./core/employee/employee.component').then(m => m.EmployeeComponent),
        children: [
            {
                path: '',
                loadComponent: () => import('./core/employee/pages/list/list.component').then(m => m.ListComponent)
            }
        ]
    }
];
