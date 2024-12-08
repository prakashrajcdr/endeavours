import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarChildComponent } from 'src/app/components/car-child/car-child.component';
import { FormsModule } from '@angular/forms';
import { MyService } from 'src/app/services/MyService';
import { HomeComponent } from 'src/app/components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { AuthGuard } from './guards/AuthGuard';

@NgModule({
  declarations: [
    AppComponent, CarChildComponent, HomeComponent, UserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [MyService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
