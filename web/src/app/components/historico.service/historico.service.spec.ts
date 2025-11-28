import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricoService } from './historico.service';

describe('HistoricoService', () => {
  let component: HistoricoService;
  let fixture: ComponentFixture<HistoricoService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HistoricoService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HistoricoService);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
