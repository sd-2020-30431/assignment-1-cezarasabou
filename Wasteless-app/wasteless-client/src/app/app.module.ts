import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './employee/employee-details/employee-details.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './employee/update-employee/update-employee.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './user/login/login.component';
import { ItemDetailsComponent } from './grocery-item/item-details/item-details.component';
import { AddItemComponent } from './grocery-item/add-item/add-item.component';
import { RegisterComponent } from './user/register/register.component';
import { GroceryListComponent } from './grocery-list/grocery-list.component';
import { MainPageComponent } from './main-page/main-page.component';
import { CreateGroceryListComponent } from './grocery-list/create-grocery-list/create-grocery-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    LoginComponent,
    ItemDetailsComponent,
    AddItemComponent,
    RegisterComponent,
    GroceryListComponent,
    MainPageComponent,
    CreateGroceryListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
