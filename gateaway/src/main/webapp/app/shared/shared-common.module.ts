import { NgModule } from '@angular/core';

import { ProjectGateawaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [ProjectGateawaySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [ProjectGateawaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class ProjectGateawaySharedCommonModule {}
