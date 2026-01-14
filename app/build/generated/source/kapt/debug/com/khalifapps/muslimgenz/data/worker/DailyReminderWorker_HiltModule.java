package com.khalifapps.muslimgenz.data.worker;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = DailyReminderWorker.class
)
public interface DailyReminderWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.khalifapps.muslimgenz.data.worker.DailyReminderWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      DailyReminderWorker_AssistedFactory factory);
}
