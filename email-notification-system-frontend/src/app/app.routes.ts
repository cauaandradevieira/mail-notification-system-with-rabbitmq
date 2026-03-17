import { Routes } from '@angular/router';
import { DashboardPageComponent } from './features/dashboard/pages/dashboard-page/dashboard-page.component';
import { AppComponent } from './app.component';
import { GroupsPageComponent } from './features/group/pages/groups-page/groups-page.component';

export const routes: Routes = [
    {path: "test", component: AppComponent},
    {path: "dashboard", component: DashboardPageComponent},
    {path: "group", component: GroupsPageComponent}

];
