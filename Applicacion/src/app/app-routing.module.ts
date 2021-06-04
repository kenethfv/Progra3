import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent} from './login/Login.component';
import { MenuComponent} from './menu/menu.component';
import { LogsComponent} from './logs/logs.component';

const routes: Routes = [
  { path: '',component: LoginComponent},
  { path: 'menu',component: MenuComponent},
  { path: 'inicio',component: InicioComponent},
  { path: 'logs',component: LogsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
