import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AuthorisationComponent } from './authorisation/authorisation.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './profile/profile.component';
import {Routes, RouterModule} from '@angular/router';

const routes: Routes =[
    { path: '', component: AuthorisationComponent},
    { path: 'profile', component: ProfileComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AuthorisationComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
