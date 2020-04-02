import {Component, NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { RegisterComponent } from "./register/register.component";
import { LoginComponent } from "./login/login.component";
import { AddItemComponent } from "./add-item/add-item.component";
import { ItemListComponent } from "./item-list/item-list.component";
import {ItemDetailsComponent} from "./item-details/item-details.component";
import {MainPageComponent} from "./main-page/main-page.component";


const routes: Routes = [

  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
  { path: 'details/:id', component: EmployeeDetailsComponent },

  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },

  { path: 'login', component: LoginComponent },

   { path: 'items', component: ItemListComponent},
  { path: 'itemDetails/:itemId', component: ItemDetailsComponent},
   { path: 'items/addItem', component: AddItemComponent },

  { path: 'mainPage', component: MainPageComponent},
  { path: 'mainPage/addGroceryList', component: MainPageComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
