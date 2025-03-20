import pandas as pd
import numpy as np
from coordinate_constant import dansothanhpho, trenhat, gianhat


data = {  # tạo dữ liệu nháp
    "ID": range(1, dansothanhpho + 1),
    "Age": np.random.randint(trenhat, gianhat, size=dansothanhpho)
}

df = pd.DataFrame(data)
average_age = df["Age"].mean()  # tuổi trung bình
df["Age_Difference"] = abs(df["Age"] - average_age)

df_sorted = df.sort_values(by="Age_Difference", ascending=False)

top_20_percent = int(len(df) * 0.2)  # Lấy 20% số người có độ chênh lệch lớn nhất
result = df_sorted.head(top_20_percent)

print(result)
