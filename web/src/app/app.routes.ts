import { Routes } from '@angular/router';
import { DefaultLoginLayout } from './components/default-login-layout/default-login-layout';
import { Conta } from './pages/conta/conta';

export const routes: Routes = [
  {
    path: "conta",
    component: Conta
  }
];
