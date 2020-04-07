import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {GroceryList} from "../grocery-list/groceryList";
import {MainPageService} from "./main-page.service";
import {Router} from "@angular/router";
import {User} from "../user/user";
import {WasteCalculator} from "./waste-calculator";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  activeUser: User;
  groceryLists: Observable<GroceryList[]>;
  wasteCalculator: WasteCalculator;

  submitted = false;
  canCalculateWaste = false;

  constructor(private mainPageService: MainPageService,
              private router: Router) { }

  ngOnInit() {
    this.wasteCalculator = new WasteCalculator();
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

  calculateWaste(groceryListId: number) {
    this.mainPageService.calculateWaste(this.activeUser.id,groceryListId,this.wasteCalculator)
      .subscribe(
        (data: WasteCalculator) =>{
          console.log(data);
          this.wasteCalculator = data;
          this.canCalculateWaste = true;
        },
        error => {
          console.log(error);
        }
      )
  }

  getWasteLevel(groceryListId: number){
    //this.wasteLevel = this.mainPageService.getWasteLevel(this.activeUser.id,groceryListId);
  }

  onSubmit(){
    this.submitted = true;
  }

}
