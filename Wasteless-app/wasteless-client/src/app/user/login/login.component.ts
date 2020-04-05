import { Component, OnInit } from '@angular/core';
import {Employee} from "../../employee/employee";
import {ActivatedRoute, Router} from '@angular/router';
import {LoginService} from "./login.service";
import {User} from "../user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  submitted = false;
  user: User;

  constructor(private router: Router,
              private activeRoute: ActivatedRoute,
              private loginService: LoginService) { }


  ngOnInit() {
    this.user = new User();
  }

  onSubmit() {
    this.submitted = true;
    this.loginService.verifyUser(this.user).subscribe(
      (user) => {
        this.goToMainPage();
      }, () => {
        console.log('Error in the login page!');
      }
    );
  }

  goToGroceryList() {
    this.router.navigate(['/items']);
  }

  goToMainPage() {
    this.router.navigate(['../mainPage'], {relativeTo: this.activeRoute});
  }
}
