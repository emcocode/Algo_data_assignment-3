import matplotlib.pyplot as plt


# qshs = [120, 117, 113, 112, 113, 114, 115, 119, 124, 130, 143, 146, 152, 157, 166, 175, 164, 156, 156, 163, 160]
# qsis = [152685, 23944, 6882, 3132, 1690, 516, 224, 130, 89, 84, 85, 83, 85, 92, 90, 87, 89, 89, 88, 92, 89]

# qshs = [115, 119, 124, 130, 143, 146, 152, 157, 166, 175, 164, 156, 156, 163, 160]
# qsis = [224, 130, 89, 84, 85, 83, 85, 92, 90, 87, 89, 89, 88, 92, 89]

# qshs = [124, 130, 143, 146, 152, 157, 166, 175, 164, 156, 156, 163, 160]
# qsis = [89, 84, 85, 83, 85, 92, 90, 87, 89, 89, 88, 92, 89]


# NYAST
# qshs = [121, 119, 109, 109, 105, 97, 94, 90, 88, 87, 86, 85, 84, 85, 85, 85, 85, 85, 85, 86]
# qsis = [109175, 24223, 7590, 3092, 1405, 563, 359, 130, 93, 84, 86, 90, 93, 99, 94, 93, 91, 90, 91, 90]

# qshs = [90, 88, 87, 86, 85, 84, 85, 85, 85, 85, 85, 85, 86]
# qsis = [138, 99, 89, 88, 96, 92, 93, 92, 94, 92, 91, 92, 94]

qshs = [88, 87, 86, 85, 84, 85, 85, 85, 85, 85, 85, 86]
qsis = [99, 89, 88, 96, 92, 93, 92, 94, 92, 91, 92, 94]

# depth = list(range(2, 41, 2))
# depth = list(range(16, 41, 2))
depth = list(range(18, 41, 2))



plt.plot(depth, qshs, label="Quick sort, heap sort")
plt.plot(depth, qsis, label="Quick sort, insert sort")
# plt.plot(depth, qs, label="Quick sort only")
plt.axhline(y=87, color='r', linestyle='-', label="Quick sort only")

plt.xticks(depth)

plt.title("1M sized array")
plt.ylim(50, 120)
plt.xlabel("Depth")
plt.ylabel("Time (ms)")
plt.legend()
plt.show()

