import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MainPageService {

  private baseUrl = 'http://localhost:8080/springboot-crud-rest/itemLists';

  constructor(private http: HttpClient) { }

  getGroceryList(listId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${listId}`);
  }

  createGroceryList(groceryList: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, groceryList);
  }

  updateItem(groceryListId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${groceryListId}`, value);
  }

  deleteItem(groceryListId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${groceryListId}`, { responseType: 'text' });
  }

  getItemLists(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
