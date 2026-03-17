import { Component, OnInit, signal } from '@angular/core';
import { DashboardCardComponent } from '../../components/dashboard-card/dashboard-card.component';
import { CARD_VIEW } from '../../const/card-value-const';
import { CardDashboard } from '../../interfaces/card-dashboard';

type Trend = "up" | "down" | "neutral";

interface RequestData {
  name: string;
  value: number;
  percentage: number;
  trend: Trend;
}

@Component({
  selector: 'app-dashboard-page',
  imports: [DashboardCardComponent],
  templateUrl: './dashboard-page.component.html',
  styleUrl: './dashboard-page.component.css'
})
export class DashboardPageComponent implements OnInit {
  cardList = signal<CardDashboard[]>(CARD_VIEW);

  ngOnInit(): void {
    this.get();
    console.log(this.cardList);
  }

  public get() {
    // simulando requisição 
    const requestData: RequestData[] = [
      {
        "name": "send emails",
        "value": 1050,
        "percentage": 30,
        "trend": "up"
      },
      {
        "name": "contacts",
        "value": 100,
        "percentage": 2,
        "trend": "down"
      },
      {
        "name": "contacts group",
        "value": 10,
        "percentage": 0,
        "trend": "neutral"
      } 
    ]
    
    this.cardList.update(items =>
      items.map(item => {
        const data = requestData.find(d => item.label === d.name);
    
        if (!data) {
          return { ...item };
        }
    
        return {
          ...item,
          label: data.name,
          value: data.value,
          percentage: data.percentage,
          trend: data.trend
        };
      })
    );

  }
}
