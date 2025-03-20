import sqlite3, random
"""
There are 20 classes in the school
    5 class have 35 students
    6 classes have 45 students
    10 classes have 30 students
    4 classes have 40 students
The average age of all students is 20 years and 8 months ~ 20.67
Write a program count the total student of each class who the age larger or smaller than the average age 6 month.
"""


def generate_sequence_with_range(
        num_elements=5*35 + 6*45 + 10*30 + 4*40,
        min_value=150,
        max_value=400
) -> str:
    # Tính tổng mục tiêu từ trung bình cộng
    target_sum = num_elements * target_mean
    sequence = []
    current_sum = 0
    v = ''
    classid = (1, 2, 3, 4, 5, ) * 35 + (6, 7, 8, 9, 10, 11, ) * 45 + (12, 13, 14, 15, 16, 17, 18, 19, 20, 21, ) * 30 + (22, 24, 25, 26, ) * 40
    classid = sorted(classid)
    assert len(classid) == num_elements

    for i in range(num_elements):
        remaining_elements = num_elements - len(sequence) - 1
        min_possible = max(min_value, target_sum - current_sum - max_value * remaining_elements)
        max_possible = min(max_value, target_sum - current_sum - min_value * remaining_elements)

        # Chọn một số ngẫu nhiên trong khoảng hợp lệ
        value = random.randint(min_possible, max_possible)
        sequence.append(value)
        v += f'({classid[i]}, {value / 10}), '
        current_sum += value
    assert sum(sequence) / len(sequence) == target_mean
    return v[:-2]


target_mean=207
# Connect to an SQLite database (or create it if it doesn't exist)
conn = sqlite3.connect('test3.db')
# Create a cursor object using the cursor() method
cursor = conn.cursor()
# Create table
cursor.execute('''CREATE TABLE Students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    ClassID INT,
    Age DECIMAL(4, 2)
);''')

# Insert a row of data
val = generate_sequence_with_range()
scri = f"""INSERT INTO Students (ClassID, Age) VALUES {val};"""
cursor.execute(scri)

scri = f"""SELECT ClassID, SUM(CASE WHEN Age > {target_mean/10 + 0.5} THEN 1 ELSE 0 END) + SUM(CASE WHEN Age < {target_mean/10 - 0.5} THEN 1 ELSE 0 END) AS Total_Count
FROM Students GROUP BY ClassID;"""
for row in cursor.execute(scri):
    print(row)

# Save (commit) the changes
conn.commit()

# Close the connection
conn.close()