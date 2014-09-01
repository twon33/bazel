// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.events;

/**
 * The ErrorEventListener is the primary means of reporting error and warning events. It is a subset
 * of the functionality of the {@link Reporter}. In most cases, you should use this interface
 * instead of the final {@code Reporter} class.
 */
public interface EventHandler {
  /**
   * Returns true iff the given tag matches the output filter.
   */
  // This method is used for the --output_filter option. This would be more
  // cleanly implemented by storing the 'tag' in Event, so this method does not have to
  // be propagated to all callers, except that test output is treated especially
  // (--output_filter is ignored for --test_output={errors,streamed}), which
  // breaks the generality.
  boolean showOutput(String label);

  /**
   * Handles an event.
   */
  public void handle(Event event);
}
