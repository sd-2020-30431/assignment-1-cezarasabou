import { Component, OnInit } from '@angular/core';
import { Item } from '../item';
import { Router } from '@angular/router';
import { ItemService } from '../item.service';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {

  item: Item =  new Item();
  submitted = false;

  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit() {
  }

  newItem(): void{
    this.submitted = false;
    this.item = new Item();
  }

   save() {
      this.itemService.createItem(this.item)
        .subscribe(data => console.log(data), error => console.log(error));
      this.item = new Item();
      this.gotoList();
    }

    onSubmit() {
      this.submitted = true;
      this.save();
    }

    gotoList() {
      this.router.navigate(['/items']);
    }

  keyDownFunction(event) {
    if(event.keyCode == 13) {
      alert('you just clicked enter');
      // rest of your code
    }
  }
}
