# Sample coroutines   

------

This is sample of several different coroutines practice

> * GlobalScope: Process级别,activity/fragment销毁了也存在
> * MainScope：在activity中使用，可以在onDestroy中取消协程
> * viewModelScope：只能在viewModel中使用，绑定viewModel声明周期
> * lifecycleScope：只能在activity、fragment中使用，绑定activity、fragment的生命周期

