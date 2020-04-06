import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {GroceryList} from "../grocery-list/groceryList";
import {MainPageService} from "./main-page.service";
import {Router} from "@angular/router";
import {User} from "../user/user";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  activeUser: User;
  groceryLists: Observable<GroceryList[]>;

  constructor(private mainPageService: MainPageService,
              private router: Router) { }

  ngOnInit() {
    this.mainPageService.getActiveUser().subscribe(
      (user) => {
        this.activeUser = user;
        this.reloadData();
      });
  }

  reloadData(){
    this.groceryLists = this.mainPageService.getAllGroceryLists(this.activeUser.id);
  }

  deleteGroceryList(groceryListId:number){
    this.mainPageService.deleteItem(this.activeUser.id,groceryListId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  groceryListDetails(groceryListId:number){
    this.router.navigate(['groceryList',groceryListId]);
  }

}
