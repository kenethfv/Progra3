import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
<<<<<<< HEAD
import {LoginComponent} from './login/Login.component';
import {MenuComponent} from './menu/menu.component';

const routes: Routes = [
  { path: '',component: LoginComponent},
  { path: 'menu',component: MenuComponent},
  
=======
import { LoginComponent} from './login/Login.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  { path: 'login', component:LoginComponent},
  { path: 'menu', component:MenuComponent}
>>>>>>> 4b929632cbc15cb304b1ac4038b9a360f64eeeb2

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
