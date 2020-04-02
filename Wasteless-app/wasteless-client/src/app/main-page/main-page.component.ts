import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {GroceryList} from "../groceryList";
import {MainPageService} from "../main-page.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {


  groceryLists: Observable<GroceryList[]>;
  constructor(private mainPageService: MainPageService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.groceryLists = this.mainPageService.getItemLists();
  }

  deleteGroceryList(groceryListId:number){
    this.mainPageService.deleteItem(groceryListId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  groceryListDetails(groceryListId:number){
    this.router.navigate(['items',groceryListId]);
  }

}
