import { Component, OnInit } from '@angular/core';
import {GroceryList} from "../groceryList";
import {MainPageService} from "../main-page.service";
import {Router} from "@angular/router";
import {Employee} from "../employee";

@Component({
  selector: 'app-create-grocery-list',
  templateUrl: './create-grocery-list.component.html',
  styleUrls: ['./create-grocery-list.component.css']
})
export class CreateGroceryListComponent implements OnInit {

  groceryList: GroceryList = new GroceryList();
  submitted = false;

  constructor(private mainPageService: MainPageService,
              private router: Router) { }

  ngOnInit() {
  }

  newGroceryList(){
    this.submitted = false;
    this.groceryList = new GroceryList();
  }

  save() {
    this.mainPageService.createGroceryList(this.groceryList)
      .subscribe(
        (data) => {
          console.log(data);
          this.groceryList = new GroceryList();
          this.goToGroceryList(this.groceryList.groceryListId);
        } ,
        error => console.log(error));

  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  goToGroceryList(groceryListId:number) {
    this.router.navigate(['groceryList',groceryListId]);
  }

  keyDownFunction(event) {
    if(event.keyCode == 13) {
      alert('you just clicked enter');
      // rest of your code
    }
  }

}
