import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UseTransacoes } from './use-transacoes';

describe('UseTransacoes', () => {
  let component: UseTransacoes;
  let fixture: ComponentFixture<UseTransacoes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UseTransacoes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UseTransacoes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
