import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

   private baseUrl = 'http://localhost:8080/springboot-crud-rest/items';

    constructor(private http: HttpClient) { }

    getItem(itemId: number): Observable<any> {
      return this.http.get(`${this.baseUrl}/${itemId}`);
    }

    createItem(item: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}`, item);
    }

    updateItem(itemId: number, value: any): Observable<Object> {
      return this.http.put(`${this.baseUrl}/${itemId}`, value);
    }

    deleteItem(itemId: number): Observable<any> {
      return this.http.delete(`${this.baseUrl}/${itemId}`, { responseType: 'text' });
    }

    getItemList(): Observable<any> {
      return this.http.get(`${this.baseUrl}`);
    }
}
