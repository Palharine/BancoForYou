import { Component } from '@angular/core';
import { DefaultLoginLayout } from '../../components/default-login-layout/default-login-layout';

@Component({
  selector: 'app-data',
  imports: [
    DefaultLoginLayout
  ],
  templateUrl: './data.html',
  styleUrl: './data.scss',
})
export class Data {

}
