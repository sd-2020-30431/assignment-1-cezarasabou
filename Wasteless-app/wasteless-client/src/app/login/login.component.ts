import { Component, OnInit } from '@angular/core';
import {Employee} from "../employee";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  submitted = false;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    this.goToMainPage();
  }

  goToGroceryList(){
    this.router.navigate(['/items']);
  }

  goToMainPage(){
    this.router.navigate(['/mainPage']);
  }

  keyDownFunction(event) {
    if(event.keyCode == 13) {
      alert('you just clicked enter');
      // rest of your code
    }
  }

}
