package com.dryad.tomidaiapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.content.Intent


class AppDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("タイトル")
            .setMessage("ここにメッセージを入力します")
            .setPositiveButton("OK") { dialog, id ->
                // このボタンを押した時の処理を書きます。
            }
            .setNegativeButton("キャンセル", null)
            .setNeutralButton("あとで", null)
        return builder.create()
    }
}

class check_update_DialogFragment : DialogFragment() {
    public interface NoticeDialogLister {
        public fun onDialogPositiveClick(dialog:DialogFragment)
        public fun onDialogNegativeClick(dialog:DialogFragment)
    }

    var mLister:NoticeDialogLister? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mLister = context as NoticeDialogLister
        } catch (e: ClassCastException) {
            throw ClassCastException("${context.toString()} must implement NoticeDialogListener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("確認")
            .setMessage("この時間には既に時間割が登録されています。\n上書きしますか？")
            .setPositiveButton("上書き") { dialog, id ->
                println("dialog:$dialog which:$id")
                mLister?.onDialogPositiveClick(this)
            }
            .setNegativeButton("キャンセル") { dialog, id ->
                println("dialog:$dialog which:$id")
                mLister?.onDialogNegativeClick(this)
            }
        return builder.create()
    }

    override fun onDestroy() {
        println("NoticeDialogFragmentのonDestroyが呼ばれたよ！")
        super.onDestroy()
    }

    override fun onDetach() {
        println("NoticeDialogFragmentのonDetachが呼ばれたよ！")
        super.onDetach()
        mLister = null

    }
}


class result_null_DialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("検索エラー")
            .setMessage("この授業コードは存在しません。")
            .setPositiveButton("OK") { dialog, id ->
                // このボタンを押した時の処理を書きます。
            }
            .setNegativeButton("戻る", null)
        return builder.create()
    }
}

class result_nomacth_DialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val str = requireArguments().getString("date_time", "")

        val builder = AlertDialog.Builder(activity)
        builder.setTitle("検索エラー")
            .setMessage("この授業コードは" + str + "ではありません。")
            .setPositiveButton("OK") { dialog, id ->
                // このボタンを押した時の処理を書きます。
            }
            .setNegativeButton("戻る", null)
        return builder.create()
    }
}