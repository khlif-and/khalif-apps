package com.khalifapps.muslimgenz.presentation.widget;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/khalifapps/muslimgenz/presentation/widget/SimpleWidget;", "Landroidx/glance/appwidget/GlanceAppWidget;", "()V", "stateDefinition", "Landroidx/glance/state/PreferencesGlanceStateDefinition;", "getStateDefinition", "()Landroidx/glance/state/PreferencesGlanceStateDefinition;", "setStateDefinition", "(Landroidx/glance/state/PreferencesGlanceStateDefinition;)V", "provideGlance", "", "context", "Landroid/content/Context;", "id", "Landroidx/glance/GlanceId;", "(Landroid/content/Context;Landroidx/glance/GlanceId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class SimpleWidget extends androidx.glance.appwidget.GlanceAppWidget {
    @org.jetbrains.annotations.NotNull()
    private androidx.glance.state.PreferencesGlanceStateDefinition stateDefinition;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> countKey = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.khalifapps.muslimgenz.presentation.widget.SimpleWidget.Companion Companion = null;
    
    public SimpleWidget() {
        super(0);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public androidx.glance.state.PreferencesGlanceStateDefinition getStateDefinition() {
        return null;
    }
    
    public void setStateDefinition(@org.jetbrains.annotations.NotNull()
    androidx.glance.state.PreferencesGlanceStateDefinition p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object provideGlance(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.glance.GlanceId id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/khalifapps/muslimgenz/presentation/widget/SimpleWidget$Companion;", "", "()V", "countKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "getCountKey", "()Landroidx/datastore/preferences/core/Preferences$Key;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.datastore.preferences.core.Preferences.Key<java.lang.Integer> getCountKey() {
            return null;
        }
    }
}