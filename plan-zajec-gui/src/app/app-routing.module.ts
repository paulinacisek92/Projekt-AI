import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { GroupScheduleComponent } from './components/group-schedule/group-schedule.component';
import { TeacherScheduleComponent } from './components/teacher-schedule/teacher-schedule.component';

const routes: Routes = [
  {
    path: '',
    redirectTo:'home',
    pathMatch: 'full',
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'plan-zajec-nauczyciela',
    component: TeacherScheduleComponent
  },
  {
    path: 'plan-zajec-grupy',
    component: GroupScheduleComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
