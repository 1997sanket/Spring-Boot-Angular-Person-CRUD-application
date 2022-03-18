import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Person } from '../model/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-list-persons',
  templateUrl: './list-persons.component.html',
  styleUrls: ['./list-persons.component.css']
})
export class ListPersonsComponent implements OnInit {

  persons: Person[];

  // = [
  //   new Person(1, 'Sanket', 'Java Angular Full Stack AWS Developer'),
  //   new Person(2, 'Martin', 'Java Developer'),
  //   new Person(3, 'Ashok', 'Doctor'),
  // ];

  constructor(private personService: PersonService, private router: Router) {

    this.personService.getAllPersons().subscribe(
      data => {
        this.persons = data;
      }
    );
  }

  ngOnInit(): void {
    this.personService.getAllPersons().subscribe(
      data => {
        this.persons = data;
      }
    );
  }

  savePerson() {
    this.router.navigate(['create']);
  }

  onUpdate(id) {
    this.router.navigate(["create", id]);
  }

  onDelete(id) {
    this.personService.deleteById(id).subscribe(
      data => {
        console.log("Successfully deleted");
        this.ngOnInit();
      }
    );


  }

}
