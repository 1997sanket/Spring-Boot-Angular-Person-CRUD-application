import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../model/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  selectedImage: File;
  error: String;
  message: String;
  person: Person = new Person(-1, "", "");

  constructor(private personService: PersonService, private router: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.person.id = this.activateRoute.snapshot.params['id'];

    //If new todo then dont populate from database
    if (this.person.id != -1) {
      this.populateInputFields(this.person.id);
    }
  }

  savePerson() {


    //Sending Person and his image together
    this.personService.savePerson(this.person).subscribe(
      data => { console.log(data + "saved") }
    );

    //console.log("Person saved and image uploaded");

    this.router.navigate(["list"]);


  }

  populateInputFields(id) {
    this.personService.getPersonById(id).subscribe(
      data => { this.person = data }
    );
  }



}
