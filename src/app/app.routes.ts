import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { SweetListComponent } from './sweets/sweet-list/sweet-list.component';
import { AddSweetComponent } from './sweets/add-sweet/add-sweet.component';

export const routes: Routes = [
  { path: '', component: SweetListComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'add', component: AddSweetComponent },
  { path: '**', redirectTo: '' }
];
