package com.mine.spy.services.accessibilityData

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class AccessibilityDataService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Implementation restored when full sources are available.
    }

    override fun onInterrupt() {
    }
}
