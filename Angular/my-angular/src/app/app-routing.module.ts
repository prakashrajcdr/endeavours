import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from 'src/app/components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { AuthGuard } from './guards/AuthGuard';


const routes: Routes = [
  {
    path: 'home', 
    component: HomeComponent,
    children: [
      {path: 'user/:name', component: UserComponent, canActivate: [AuthGuard]}
    ]
  },
  {
    path: '**',
    redirectTo: '/'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
