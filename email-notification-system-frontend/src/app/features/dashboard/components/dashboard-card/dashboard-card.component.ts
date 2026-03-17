import { Component, Input, OnInit, signal } from '@angular/core';
import { CardDashboard } from '../../interfaces/card-dashboard';
import { TrendDashboard } from '../../interfaces/trend-dashboard';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-dashboard-card',
  imports: [CommonModule],
  templateUrl: './dashboard-card.component.html',
  styleUrl: './dashboard-card.component.css'
})

export class DashboardCardComponent implements OnInit
{
  @Input() card!: CardDashboard;
  
  trend = signal<TrendDashboard>({result: "0%", background: "bg-gray-600", textColor: "bg-gray-100"} );

  ngOnInit() : void
  {
    this.trend.set(this.trendColorClass());
  }

  public trendColorClass(): TrendDashboard
  {
    if(this.card.trend === "up")
    {
      return {result: "+" + this.card.percentage + "%" ,background: "bg-green-100", textColor: "text-green-600"}
    }

    if(this.card.trend === "down")
    {
      return {result: "-" + this.card.percentage + "%" ,background: "bg-red-100", textColor: "text-red-600"}
    }

    if(this.card.trend === "neutral")
    {
      return {result: "" + this.card.percentage + "%" ,background: "bg-gray-100", textColor: "text-gray-600"}
    }

    return {...this.trend()};
  }

}
