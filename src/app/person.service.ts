import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Person } from './model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  API: String = "http://springbootpersoncrudwithawsrds-env.eba-iujebm66.us-east-2.elasticbeanstalk.com"
  //DummyApi: String = "http://localhost:5000";

  constructor(private http: HttpClient) { }

  getAllPersons() {
    return this.http.get<Person[]>(this.API + "/persons");
  }

  getPersonById(id) {
    return this.http.get<Person>(this.API + "/persons/" + id);
  }

  savePerson(person: Person) {
    //Then save person entity
    return this.http.post(this.API + "/persons", person);

  }

  deleteById(id) {
    return this.http.delete(this.API + "/persons/" + id);
  }

  // saveImage(uploadImageData, id: number) {
  //   return this.http.post(this.DummyApi + "/persons/image/" + 3, uploadImageData);
  // }

  // getImage() {
  //  return this.http.get('http://localhost:8080/image/get/' + this.imageName)
  // }
}
