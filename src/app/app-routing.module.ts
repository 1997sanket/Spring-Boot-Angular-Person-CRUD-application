import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BodyComponent } from './body/body.component';
import { CreateComponent } from './create/create.component';
import { ListPersonsComponent } from './list-persons/list-persons.component';

const routes: Routes = [
  { path: "", component: BodyComponent },
  { path: "home", component: BodyComponent },
  { path: "create", component: CreateComponent },
  { path: "list", component: ListPersonsComponent },
  { path: "create/:id", component: CreateComponent },
  { path: "**", component: BodyComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
