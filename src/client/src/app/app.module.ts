import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { AppPruebaService } from './services/app-prueba.service';
import { FacturasComponent } from './components/facturas/facturas.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'verFacturas',
    component: FacturasComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FacturasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AppPruebaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
