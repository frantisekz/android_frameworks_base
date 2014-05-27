/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.hdmi;

import android.hardware.hdmi.HdmiCec;

/**
 * Represent a logical device of type Playback residing in Android system.
 */
final class HdmiCecLocalDevicePlayback extends HdmiCecLocalDevice {

    HdmiCecLocalDevicePlayback(HdmiCecController controller) {
        super(controller, HdmiCec.DEVICE_PLAYBACK);
    }

    @Override
    void init() {
        allocateAddress(mDeviceType);
        mController.sendCommand(HdmiCecMessageBuilder.buildReportPhysicalAddressCommand(
                mAddress, mController.getPhysicalAddress(), mDeviceType));
    }
}