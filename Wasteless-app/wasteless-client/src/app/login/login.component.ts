import { Component, OnInit } from '@angular/core';
import {Employee} from "../employee";

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
  }

  goToGroceryList(){
    this.router.navigate(['/items']);
  }

}
