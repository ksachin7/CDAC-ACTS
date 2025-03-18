#include<iostream>
#include<fstream>
#include<string>

using namespace std;

void bin_cpy(ifstream &fin, ofstream &fout){
	char ch;

	while(fin){
		fin.get(ch);
		fout<<ch;
	}
	cout << "File copied successfully!" << endl;
}

int main(int argc, char *argv[]){

	if(argc < 3)
	{
        cout << "\nPlease provide source and destination file names" << endl;
		return -1;
	}

	ifstream fin(argv[1], ios::binary);
	ofstream fout(argv[2], ios::binary);

    if (!fin) {
        cout << "Unable to open source file!" << endl;
        return -1;
    }
    if (!fout) {
        cout << "Unable to open destination file!" << endl;
        return -1;
    }

	bin_cpy(fin, fout);

	fin.close();
	fout.close();

	return 0;
}