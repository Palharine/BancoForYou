import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { TransferenciaComponent } from './pages/transferencia/transferencia.component';
import { CreateChatComponent } from './pages/create-chat/create-chat.component';
import { ChatComponent } from './pages/chat/chat.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TransferenciaComponent,
    CreateChatComponent,
    ChatComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}

