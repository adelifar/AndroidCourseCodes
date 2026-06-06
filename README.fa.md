# 📱 دوره جامع پروژه‌محور برنامه نویسی اندروید: از مبانی تا برنامه های بزرگ
### 🚀 جامع‌ترین منبع آموزش ساخت ۱۴ اپلیکیشن واقعی با جاوا، معماری MVVM و Android Jetpack

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM-blue?style=for-the-badge)](https://developer.android.com/jetpack/guide)
[![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)]()

[🇬🇧 English Version](README.md) | [🇮🇷 نسخه فارسی](README.fa.md)

---

## 👋 به مخزن کدهای دوره خوش آمدید!

این مخزن حاوی **سورس‌کد کامل** تمام پروژه‌هایی است که در دوره آموزشی **«دوره جامع پروژه‌محور برنامه نویسی اندروید: از مبانی تا برنامه های بزرگ»** تدریس شده است. چه یک تازه‌کار باشید که می‌خواهد اولین قدم‌ها را بردارد، و چه توسعه‌دهنده‌ای که به دنبال یادگیری معماری مدرن اندروید است، این کدها برای شماست.

🔗 **[ثبت‌نام و مشاهده ویدیوهای کامل دوره] (https://tosinso.com/courses/android-programming)**
*(برای یادگیری خط‌به‌خط این کدها و مشاهده آموزش‌های ویدیویی، روی لینک بالا کلیک کنید)*

---

## 📚 محتویات این مخزن چیست؟
این مخزن به صورت پوشه‌بندی شده و منظم طراحی شده است. هر پوشه مربوط به یک فصل یا پروژه خاص در دوره است:

### 🌱 فاز ۱: مبانی و شروع کار
*   **📂 `01-HelloWorld`**: آشنایی با ساختار پروژه اندروید.
*   **📂 `02-UI-Components`**: کار با ابزارهای پایه مثل `TextView`, `Button`, `EditText`.
*   **📂 `03-Layouts-Mastery`**: طراحی صفحات واکنش‌گرا با `ConstraintLayout` و `LinearLayout`.

### 🛠 فاز ۲: مفاهیم هسته‌ای اندروید
*   **📂 `04-BMI-Calculator`**: ساخت اپلیکیشن کامل با منطق ریاضی، اینتنت‌ها و تست‌ها.
*   **📂 `05-ListView-Grid`**: نمایش لیست‌ها با استفاده از `ListView` و `GridView` استاندارد.
*   **📂 `06-The-Quiz-App`**: پیاده‌سازی منطق بازی و مدیریت وضعیت‌ها (State Management).

### 🚀 فاز ۳: رابط کاربری پیشرفته و متریال دیزاین
*   **📂 `07-RecyclerView-Pro`**: ساخت لیست‌های حرفه‌ای و بهینه با `RecyclerView` و `CardView`.
*   **📂 `08-Material-Me`**: اصول طراحی متریال دیزاین برای داشتن اپلیکیشنی زیبا.

### 🏗 فاز ۴: معماری مدرن و دیتابیس (سطح حرفه‌ای)
*   **📂 `09-Student-Database`**:
    *   پیاده‌سازی کامل عملیات **CRUD** (افزودن، خواندن، ویرایش، حذف).
    *   کار با دیتابیس **Room**.
    *   پیاده‌سازی معماری **MVVM** (Model-View-ViewModel).
    *   استفاده از **LiveData** و **ViewModel**.
    *   کار با **Data Binding**.

### 🌐 فاز ۵: ارتباط با اینترنت و پروژه‌های واقعی
*   **📂 `10-Movie-App-Clean`** (پروژه نهایی):
    *   دریافت اطلاعات از **REST API** (وب‌سرویس TMDB).
    *   استفاده از کتابخانه **Retrofit 2** برای ارتباط با سرور.
    *   لود کردن تصاویر با **Glide**.
    *   پیاده‌سازی **Paging Library** برای اسکرول بی‌نهایت.
    *   مدیریت جابجایی صفحات با **Navigation Component**.

---

## 🛠 تکنولوژی‌ها و کتابخانه‌های استفاده شده
ما در این دوره از ابزارها و استانداردهای روز صنعت استفاده کرده‌ایم:

*   **زبان برنامه‌نویسی**: جاوا (Java) ☕
*   **محیط توسعه**: Android Studio
*   **معماری**: MVVM (Model-View-ViewModel)
*   **کامپوننت‌های جت‌پک (Jetpack)**:
    *   `Lifecycle`, `ViewModel`, `LiveData`
    *   `Room` (دیتابیس آفلاین)
    *   `Navigation`
    *   `Paging 3`
    *   `Data Binding`
*   **شبکه**: Retrofit 2, Gson
*   **لود تصاویر**: Glide
*   **طراحی**: Material Design, ConstraintLayout


---

## 🏃 راهنمای اجرای پروژه‌ها
1.  این مخزن را **Clone** یا دانلود کنید:
    ```bash
    git clone https://github.com/adelifar/AndroidCourseCodes.git
    ```
2.  نرم‌افزار **Android Studio** را باز کنید.
3.  گزینه **Open an Existing Project** را انتخاب کنید.
4.  وارد پوشه پروژه مورد نظر شوید (مثلاً `10-Movie-App-Clean`) و روی OK کلیک کنید.
5.  صبر کنید تا بیلد گریدل (Gradle Build) تمام شود و سپس دکمه **Run** ▶️ را بزنید.

---

## ❤️ حمایت و ارتباط با ما
اگر این کدها برایتان مفید بود یا دانشجوی دوره هستید:
*   🌟 با دادن **Star (ستاره)** به این مخزن در بالای صفحه، از ما حمایت کنید!
*   📲 ما را در اینستاگرام دنبال کنید: **[https://instagram.com/Mehdiadelidev]**
*   📲 ما را در یوتیوب سابسکرایب کنید: **[https://www.youtube.com/@mehdiadelidev]**
*

---
امیدوارم لذت ببرید
