/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.cli.common.arguments

import org.jetbrains.kotlin.cli.common.arguments.K2JsArgumentConstants.CALL
import org.jetbrains.kotlin.cli.common.arguments.K2JsArgumentConstants.NO_CALL

class K2JSCompilerArguments : CommonCompilerArguments() {
    companion object {
        @JvmStatic private val serialVersionUID = 0L
    }

    @GradleOption(DefaultValues.StringNullDefault::class)
    @Argument(value = "-output", valueDescription = "<path>", description = "Output file path")
    var outputFile: String? by NullableStringFreezableVar(null)

    @GradleOption(DefaultValues.BooleanTrueDefault::class)
    @Argument(value = "-no-stdlib", description = "Don't use bundled Kotlin stdlib")
    var noStdlib: Boolean by FreezableVar(false)

    @Argument(
            value = "-libraries",
            valueDescription = "<path>",
            description = "Paths to Kotlin libraries with .meta.js and .kjsm files, separated by system path separator"
    )
    var libraries: String? by NullableStringFreezableVar(null)

    @GradleOption(DefaultValues.BooleanFalseDefault::class)
    @Argument(value = "-source-map", description = "Generate source map")
    var sourceMap: Boolean by FreezableVar(false)

    @GradleOption(DefaultValues.StringNullDefault::class)
    @Argument(value = "-source-map-prefix", description = "Prefix for paths in a source map")
    var sourceMapPrefix: String? by NullableStringFreezableVar(null)

    @Argument(
            value = "-source-map-base-dirs",
            deprecatedName = "-source-map-source-roots",
            valueDescription = "<path>",
            description = "Base directories which are used to calculate relative paths to source files in source map"
    )
    var sourceMapBaseDirs: String? by NullableStringFreezableVar(null)

    /**
     * SourceMapEmbedSources should be null by default, since it has effect only when source maps are enabled.
     * When sourceMapEmbedSources are not null and source maps is disabled warning is reported.
     */
    @GradleOption(DefaultValues.JsSourceMapContentModes::class)
    @Argument(
            value = "-source-map-embed-sources",
            valueDescription = "{ always, never, inlining }",
            description = "Embed source files into source map"
    )
    var sourceMapEmbedSources: String? by NullableStringFreezableVar(null)

    @GradleOption(DefaultValues.BooleanTrueDefault::class)
    @Argument(value = "-meta-info", description = "Generate .meta.js and .kjsm files with metadata. Use to create a library")
    var metaInfo: Boolean by FreezableVar(false)

    @GradleOption(DefaultValues.JsEcmaVersions::class)
    @Argument(value = "-target", valueDescription = "{ v5 }", description = "Generate JS files for specific ECMA version")
    var target: String? by NullableStringFreezableVar(null)

    @GradleOption(DefaultValues.JsModuleKinds::class)
    @Argument(
            value = "-module-kind",
            valueDescription = "{ plain, amd, commonjs, umd }",
            description = "Kind of a module generated by compiler"
    )
    var moduleKind: String? by NullableStringFreezableVar(K2JsArgumentConstants.MODULE_PLAIN)

    @GradleOption(DefaultValues.JsMain::class)
    @Argument(value = "-main", valueDescription = "{$CALL,$NO_CALL}", description = "Whether a main function should be called")
    var main: String? by NullableStringFreezableVar(null)

    @Argument(
            value = "-output-prefix",
            valueDescription = "<path>",
            description = "Path to file which will be added to the beginning of output file"
    )
    var outputPrefix: String? by NullableStringFreezableVar(null)

    @Argument(
            value = "-output-postfix",
            valueDescription = "<path>",
            description = "Path to file which will be added to the end of output file"
    )
    var outputPostfix: String? by NullableStringFreezableVar(null)

    // Advanced options


    @Argument(value = "-Xir", description = "Use IR backend")
    var irBackend: Boolean by FreezableVar(false)

    @Argument(
        value = "-Xir-produce-only",
        valueDescription = "{ klib, js }",
        description = "Type of output to produce. Overrides -meta-info argument."
    )
    var irProduceOnly: String? by NullableStringFreezableVar(null)

    @Argument(
        value = "-Xir-legacy-gradle-plugin-compatibility",
        description = "Make KLIB generation compatible with legacy gradle plugin"
    )
    var irLegacyGradlePluginCompatibility: Boolean by FreezableVar(false)

    @GradleOption(DefaultValues.BooleanTrueDefault::class)
    @Argument(value = "-Xtyped-arrays", description = "Translate primitive arrays to JS typed arrays")
    var typedArrays: Boolean by FreezableVar(true)

    @GradleOption(DefaultValues.BooleanFalseDefault::class)
    @Argument(value = "-Xfriend-modules-disabled", description = "Disable internal declaration export")
    var friendModulesDisabled: Boolean by FreezableVar(false)

    @Argument(
            value = "-Xfriend-modules",
            valueDescription = "<path>",
            description = "Paths to friend modules"
    )
    var friendModules: String? by NullableStringFreezableVar(null)

    @Argument(
        value = "-Xmeasure-performance",
        valueDescription = "<path>",
        description = "Paths to friend modules"
    )
    var measurePerformance: String? by NullableStringFreezableVar(null)
}
