import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { TransferenciaComponent } from './pages/transferencia/transferencia.component';
import { CreateChatComponent } from './pages/create-chat/create-chat.component';
import { ChatComponent } from './pages/chat/chat.component';

const routes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'transferencia', component: TransferenciaComponent },
  { path: 'chat', component: CreateChatComponent },
  { path: 'chat/:chatId', component: ChatComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

