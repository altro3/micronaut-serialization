/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.serde.config.naming;

import io.micronaut.core.annotation.AnnotatedElement;
import io.micronaut.core.naming.NameUtils;
import io.micronaut.core.util.StringUtils;

/**
 * Lower dot case strategy.
 */
public final class LowerDotCaseStrategy implements PropertyNamingStrategy {
    @Override
    public String translate(AnnotatedElement element) {
        String name = element.getName();
        if (StringUtils.isNotEmpty(name)) {
            return NameUtils.hyphenate(name, true)
                    .replace('-', '.');
        }
        return name;
    }
}
