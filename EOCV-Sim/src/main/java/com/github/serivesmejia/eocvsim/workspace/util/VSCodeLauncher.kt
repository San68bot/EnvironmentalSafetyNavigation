/*
 * Copyright (c) 2021 Sebastian Erives
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.github.serivesmejia.eocvsim.workspace.util

import com.github.serivesmejia.eocvsim.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import com.github.serivesmejia.eocvsim.util.SysUtil
import kotlinx.coroutines.DelicateCoroutinesApi
import java.io.File

object VSCodeLauncher {

    private val TAG = "VSCodeLauncher"

    fun launch(workspace: File) {
        Log.info(TAG, "Opening VS Code...")

        val result = SysUtil.runShellCommand("code \"${workspace.absolutePath}\"")

        if(result.output.isNotEmpty()) Log.info(TAG, result.output)

        if(result.exitCode == 0)
            Log.info(TAG, "VS Code opened")
        else
            Log.info(TAG, "VS Code failed to open")
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun asyncLaunch(workspace: File) = GlobalScope.launch(Dispatchers.IO) { launch(workspace) }

}