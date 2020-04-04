import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../user/user";
import {GroceryList} from "../grocery-list/groceryList";

@Injectable({
  providedIn: 'root'
})
export class MainPageService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getActiveUser(): Observable<any> {
    return this.http.get(`${this.baseUrl}/activeUser`);
  }

  getAllGroceryLists(): Observable<any> {
    return this.http.get(`${this.baseUrl}/groceryLists`);
  }

  getGroceryList(listId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/groceryList/${listId}`);
  }

  createGroceryList(groceryList: string, userId: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/${userId}/createGroceryList`, groceryList);
  }

  updateItem(groceryListId: number, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${groceryListId}`, value);
  }

  deleteItem(groceryListId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${groceryListId}`, { responseType: 'text' });
  }
}
